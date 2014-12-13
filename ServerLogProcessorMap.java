package com.sudha.hadoop.examples;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ServerLogProcessorMap extends Mapper<Text, Text, Text, MultiValueTypesWritable>{
	private Text requestText = new Text();
	private IntWritable responseSize = new IntWritable();
	
	@Override
	public void map(Text key, Text value, Context context) throws IOException, InterruptedException{
		String[] words = value.toString().split("\t");
		requestText.set(words[1]);
		responseSize.set(Integer.parseInt(words[3]));
		
		context.write(key, new MultiValueTypesWritable(requestText));
		context.write(key, new MultiValueTypesWritable(responseSize));
	}
	
}
