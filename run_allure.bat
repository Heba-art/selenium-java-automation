@echo off
setlocal ENABLEEXTENSIONS

rem --- 1. Define folder variables
set "RES=target\allure-results"
set "REP=target\allure-report"

echo Running Maven tests...
rem --- 2. Run the Maven tests
call mvn -q test

rem --- 3. Copy history from the previous report
if exist "%REP%\history" (
    xcopy /E /I /Y "%REP%\history" "%RES%\history" >nul
)

echo Generating Allure report...
rem --- 4. Generate the new Allure report
call allure generate "%RES%" -o "%REP%" --clean

echo Starting Allure web server to open the report...
rem --- 5. Open the report using Allure's web server (Correct Method)
call allure open "%REP%"

endlocal