1. Unix 设置环境变量<br>

    1.1. `vim ~/.bash_profile`<br>

    1.2. <br>
        `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-1.8.jdk/Contents/Home`<br>
        `export PATH=$JAVA_HOME/bin:$PATH`<br>
        `export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar`<br>
    
    1.3. `resource  ~/.bash_profile`<br>

2. Windows 设置环境变量(环境变量不区分大小写)<br>
   2.1. cmd.exe <br>
   2.2. <br>
      `set JAVA_HOME=D:\Program Files\Java\jdk1.8.0` <br>
      `set PATH=%JAVA_HOME%\bin;%path%`<br>
      `set CLASSPATH=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\bin\tools.jar`<br>
   2.3. 完成
      
   