@echo off
setlocal
set "JAVA_HOME=C:\Users\Christian\AppData\Roaming\Code\User\globalStorage\pleiades.java-extension-pack-jdk\java\21"
set "PATH=%JAVA_HOME%\bin;%PATH%"
set "MAVEN_HOME=C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2025.2.6.1\plugins\maven\lib\maven3"
set "MAVEN_BIN=%MAVEN_HOME%\bin"
if exist "%MAVEN_BIN%\mvn.cmd" (
  call "%MAVEN_BIN%\mvn.cmd" %*
) else (
  echo Maven executable not found at %MAVEN_BIN%\mvn.cmd
  exit /b 1
)
