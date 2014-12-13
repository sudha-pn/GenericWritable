package com.sudha.hadoop.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ServerLogProcessorJob implements Tool
{
	private Configuration conf;
	
	@Override
	public Configuration getConf()
	{
		return conf;
	}
	
	@Override
	public void setConf(Configuration conf)
	{
		this.conf = conf;
	}
	
	@Override
	public int run(String args[]) throws Exception
	{
		Job gwJob = new Job(getConf());
		
		gwJob.setJobName("Web Log Reader");
		gwJob.setJarByClass(getClass());
		
		gwJob.setMapperClass(ServerLogProcessorMap.class);
		gwJob.setReducerClass(ServerLogProcessorReduce.class);
		
		gwJob.setInputFormatClass(KeyValueTextInputFormat.class);
		
		gwJob.setMapOutputKeyClass(Text.class);
		gwJob.setMapOutputValueClass(MultiValueTypesWritable.class);
		gwJob.setOutputKeyClass(Text.class);
		gwJob.setOutputValueClass(Text.class);
		
		FileInputFormat.setInputPaths(gwJob, new Path(args[0]));
		FileOutputFormat.setOutputPath(gwJob, new Path(args[1]));
		
		return gwJob.waitForCompletion(true)?0:-1;
		
	}
	
	public static void main(String args[]) throws Exception
	{
		ToolRunner.run(new Configuration(), new ServerLogProcessorJob(), args);
	}
}
