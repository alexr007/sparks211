### compile

`sbt spark247s211/assembly`

### copy to spark folder

`cp ./spark247s211/target/scala-2.11/spark247s211-assembly-0.0.3.jar ~/rw`

### submit to spark

`
/usr/bin/spark-2.4.7-bin-hadoop2.7/bin/spark-submit \ 
--class org.alexr.SparkApplication \
--master local[2] \
./spark247s211-assembly-0.0.3.jar
`

### "com.datastax.spark" %% "spark-cassandra-connector" compatibility

- versions "2.4.1" and less DON'T work with DSE 6.8
- versions "2.4.2" and higher DO work fine

### other cassandra links

https://k8ssandra.io/  
https://k8ssandra.io/community/
https://github.com/k8ssandra/k8ssandra
https://twitter.com/k8ssandra
https://www.softserveinc.com/en-us/blog/how-to-setup-cassandra-spark-tableau
https://thenewstack.io/a-case-for-databases-on-kubernetes-from-a-former-skeptic/
http://stargate.io
