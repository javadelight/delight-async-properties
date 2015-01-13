package de.mxro.async.properties.tests

import de.mxro.async.properties.jre.Properties
import de.oehme.xtend.junit.JUnit
import org.junit.Test

@JUnit
class TestSetValue {
	
	@Test
	def void test() {
		
		val props = Properties.create(Properties.defaultFactory)
		
		props.record(Properties.set("value", "string"));
		
	}
	
}