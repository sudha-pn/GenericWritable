GenericWritable
===============

<b>Abstract:</b><br>
	The above example demonstrates how to wrap multiple value instances belonging to different datatypes emitted from the mapper using GenericWritable class (As Hadoop reducers do not allow multiple input value types).
	
<b>Usage:</b><br>
1. When performing reducer side joins<br>
2. To avoid complexity of having multiple MapReduce computations to summarize different types of properties in a data set.

<b>Details:</b><br>
Sample Input Data from a Server log file:

<code>199.72.81.55	[01/Jul/1995:00:00:01 -0400]	   "GET /history/apollo/ HTTP/1.0"	200	6245</code>

The Input data is a tab separated file holding the information of i.e. hostname, time, request url, status, requests byte size and this sample aggregates the total number of bytes served from the web server to particular host and also outputs a tab-separated list of URLs requested by the particular host.

The output after running this sample will be as below:

<code>199.120.110.21	8264	"GET /shuttle/missions/sts-73/sts-73-patch-small.gif HTTP/1.0"	"GET /shuttle/missions/sts-73/mission-sts-73.html HTTP/1.0"</code><br><br>
<code>199.72.81.55	6245	"GET /history/apollo/ HTTP/1.0"</code>

<b>For more info refer:</b><br>
Hadoop MapReduce Cookbook – Chapter 4 – Emitting data of different value types from a mapper.
