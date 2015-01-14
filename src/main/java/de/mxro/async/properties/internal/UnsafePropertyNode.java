package de.mxro.async.properties.internal;

import de.mxro.async.Operation;
import de.mxro.async.callbacks.ValueCallback;
import de.mxro.async.properties.PropertyData;
import de.mxro.async.properties.PropertyFactory;
import de.mxro.async.properties.PropertyNode;
import de.mxro.async.properties.PropertyOperation;
import de.mxro.async.properties.values.ObjectValue;
import de.mxro.fn.Success;
import de.mxro.promise.Promise;
import de.mxro.promise.PromisesCommon;

/**
 * <p>
 * A non-thread safe implementation of {@link PropertyNode}.
 * 
 * @author <a href="http://www.mxro.de">Max Rohde</a>
 *
 */
public class UnsafePropertyNode implements PropertyNode {

    private final PropertyData data;

    @Override
    public <R> Promise<R> record(final PropertyOperation<R> op) {

        return PromisesCommon.createUnsafe(new Operation<R>() {

            @Override
            public void apply(final ValueCallback<R> callback) {
                final R res;
                try {
                    res = op.perform(data);
                } catch (final Throwable t) {
                    callback.onFailure(t);
                    return;
                }
                callback.onSuccess(res);
            }
        });

    }

    public UnsafePropertyNode(final PropertyFactory factory) {
        super();
        this.data = new PropertyDataImpl(factory);

    }

    @Override
    public Promise<Object> retrieve(final String id) {
        return retrieve(id, Object.class);
    }

    @Override
    public void retrieve(final String id, final ValueCallback<Object> cb) {
        retrieve(id, Object.class);
    }

    @Override
    public <T> Promise<T> retrieve(final String id, final Class<T> type) {
        return PromisesCommon.createUnsafe(new Operation<T>() {

            @Override
            public void apply(final ValueCallback<T> callback) {
                retrieve(id, type, callback);
            }
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void retrieve(final String id, final Class<T> type, final ValueCallback<T> cb) {
        if (type.equals(Object.class)) {
            final Object value = data.get(id);
            if (value instanceof ObjectValue) {
                final ObjectValue objectValue = (ObjectValue) value;
                cb.onSuccess((T) objectValue.value());
                return;
            }
            cb.onSuccess((T) value);
            return;
        }

        final T value = data.get(id, type);
        if (value instanceof ObjectValue) {
            final ObjectValue objectValue = (ObjectValue) value;
            cb.onSuccess((T) objectValue.value());
            return;
        }

        cb.onSuccess(value);
    }

    @Override
    public Promise<Success> stop() {

        return PromisesCommon.createUnsafe(new Operation<Success>() {

            @Override
            public void apply(final ValueCallback<Success> callback) {
                stop(callback);
            }
        });
    }

    @Override
    public void stop(final ValueCallback<Success> cb) {
        cb.onSuccess(Success.INSTANCE);
    }

    @Override
    public void print() {
        System.out.println(data.toString());
    }

    @Override
    public Promise<String> render() {

        return PromisesCommon.createUnsafe(new Operation<String>() {

            @Override
            public void apply(final ValueCallback<String> callback) {
                render(callback);
            }
        });
    }

    @Override
    public void render(final ValueCallback<String> cb) {

        cb.onSuccess(data.toString());
    }

}
