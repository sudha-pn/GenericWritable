package com.sudha.hadoop.examples;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;

public class ServerLogProcessorReduce extends Reducer<Text, MultiValueTypesWritable, Text, Text>{
	private Text result = new Text();
	
	@Override
	public void reduce(Text key, Iterable<MultiValueTypesWritable> values, Context context) 
			throws IOException, InterruptedException{
		
		int sum = 0;
		StringBuilder requests = new StringBuilder();
		
		for(MultiValueTypesWritable MultiValueTypesWritable : values){
			Writable writable = MultiValueTypesWritable.get();
			if(writable instanceof IntWritable){
				sum += ((IntWritable)writable).get();
			}else{
				requests.append(((Text)writable).toString());
				requests.append("\t");
			}
		}
		result.set(sum + "\t" +requests);
		context.write(key, result);
	}

}
