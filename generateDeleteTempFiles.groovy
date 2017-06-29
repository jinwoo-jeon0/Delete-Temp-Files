pipelineJob('Delete temp files pipeline') {
	definition {
		cps {
			script($/\
				pipeline {
					agent {
						node {
							label 'master'
							customWorkspace '${WORKSPACE.replace($/\/$, $/\\/$)}'
						}
					}

					options {
						buildDiscarder(logRotator(daysToKeepStr:'14'))
						timestamps()
					}

					stages {
						stage('generate') {
							steps {
								jobDsl removedConfigFilesAction: 'DELETE', removedJobAction: 'DELETE', removedViewAction: 'DELETE', scriptText: $$$/
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
call "D:\\Documents\\Batch Jobs\\delete_temp_files.bat"''')
		batchFile('''set TEMP=D:\\Temp
call "D:\\Documents\\Batch Jobs\\delete_temp_files.bat"''')
	}
}
$/$$
							}
						}
					}
				}
			/$.stripIndent())
		}
	}
}

