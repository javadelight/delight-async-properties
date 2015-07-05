package de.mxro.async.properties.internal;

import delight.async.AsyncCommon;
import delight.async.Operation;
import delight.async.callbacks.ValueCallback;
import delight.functional.Closure;
import delight.functional.Success;
import delight.promise.Promise;
import delight.promise.helper.PromiseFactory;

import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.PropertyOperation;
import de.mxro.concurrency.schedule.AccessThread;
import de.mxro.concurrency.schedule.Step;

public class SynchronizedPropertyNode implements PropertyNode {

    private final PropertyNode decorated;

    private final AccessThread accessThread;

    private final PromiseFactory promiseFactory;

    @Override
    public <R> Promise<R> record(final PropertyOperation<R> op) {

        final Promise<R> promise = promiseFactory.promise(new Operation<R>() {

            @Override
            public void apply(final ValueCallback<R> callback) {
                accessThread.offer(new Step() {

                    @Override
                    public void process() {
                        final R res;
                        try {
                            res = op.perform(decorated.getDataUnsafe());
                        } catch (final Throwable t) {
                            callback.onFailure(t);
                            return;
                        }
                        callback.onSuccess(res);
                    }
                });
                accessThread.startIfRequired();
            }
        });

        promise.get(new Closure<R>() {

            @Override
            public void apply(final R o) {

            }
        });

        return promise;

    }

    public SynchronizedPropertyNode(final PropertyNode decorated, final AccessThread accessThread,
            final PromiseFactory promiseFactory) {
        super();
        this.decorated = decorated;
        this.accessThread = accessThread;
        this.promiseFactory = promiseFactory;
    }

    @Override
    public <T> Promise<T> retrieve(final String id, final Class<T> type) {

        return promiseFactory.promise(new Operation<T>() {

            @Override
            public void apply(final ValueCallback<T> cb) {
                retrieve(id, type, cb);
            }
        });
    }

    @Override
    public <T> void retrieve(final String id, final Class<T> type, final ValueCallback<T> cb) {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {

                decorated.retrieve(id, type, cb);
            }
        });
        this.accessThread.startIfRequired();
    }

    @Override
    public Promise<Object> retrieve(final String id) {
        return retrieve(id, Object.class);
    }

    @Override
    public void retrieve(final String id, final ValueCallback<Object> cb) {
        retrieve(id, Object.class, cb);
    }

    @Override
    public Promise<Success> stop() {

        return promiseFactory.promise(new Operation<Success>() {

            @Override
            public void apply(final ValueCallback<Success> callback) {
                stop(callback);
            }
        });
    }

    @Override
    public void stop(final ValueCallback<Success> cb) {
        this.accessThread.shutdown(AsyncCommon.wrap(cb));
    }

    @Override
    public void print() {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.print();
            }
        });
        this.accessThread.startIfRequired();
    }

    @Override
    public Promise<String> render() {

        return promiseFactory.promise(new Operation<String>() {

            @Override
            public void apply(final ValueCallback<String> callback) {
                render(callback);
            }
        });
    }

    @Override
    public void render(final ValueCallback<String> cb) {
        this.accessThread.offer(new Step() {

            @Override
            public void process() {
                decorated.render(cb);
            }
        });
        this.accessThread.startIfRequired();
    }

    @Override
    public PropertyData getDataUnsafe() {
        return decorated.getDataUnsafe();
    }

}
