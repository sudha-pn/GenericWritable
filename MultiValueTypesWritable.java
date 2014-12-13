package com.sudha.hadoop.examples;

import org.apache.hadoop.io.GenericWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class MultiValueTypesWritable extends GenericWritable{
	
		static Class[] CLASSES = new Class[] {
		IntWritable.class,
		Text.class
	};
	
	public MultiValueTypesWritable(){
	}
	
	public MultiValueTypesWritable(Writable value){
		set(value);
	}
	
	protected Class[] getTypes(){
		return CLASSES;
	}

}
