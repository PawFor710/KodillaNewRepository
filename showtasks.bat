call ./runcrud
if "%ERRORLEVEL%" == "0" goto website
echo.
echo Runcrud failed
goto fail

:website
start http://localhost:8080/crud/v1/task/tasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Something went wrong
goto fail

:fail
echo.
echo There ware errors

:end
echo.
echo Work is finished