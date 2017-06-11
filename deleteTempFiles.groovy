freeStyleJob('delete temp files')
{
	logRotator
	{
		daysToKeep(7)
	}

	triggers
	{
		cron('@daily')
	}

	steps
	{
		batchFile('''echo TEMP=%TEMP%
call \"D:\\Documents\\Batch Jobs\\delete_temp_files.bat\"''')
	batchFile('''set TEMP=D:\\Temp
call \"D:\\Documents\\Batch Jobs\\delete_temp_files.bat\"''')
	}
}

