# HttpUrlConnectionUtilDemo

一个自己封装的用HttpUrlConnection请求的网络工具类，但只适合新手研究或者做些小demo用下，
毕竟现在对于Android开发的网络框架有很多，而且很好很强大。

目前支持的功能：

1、GET，POST请求

2、支持返回String，Byte[]数组，以及自定义的Model类

3、请求的回调已处理过，现在的回调在UI线程，所以可以直接更新UI

同样的，如果写demo啥的，可以按照以下方式依赖进项目：

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```


```
	dependencies {
	        compile 'com.github.MZCretin:HttpUrlConnectionUtilDemo:v1.0'
	}

```

后面如果有需要，我会加上下载文件的方法。

如果有啥问题，欢迎交流：792075058    mxnzp_life@163.com