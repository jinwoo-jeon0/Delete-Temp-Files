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
								jobDsl removedJobAction: 'DELETE', removedViewAction: 'DELETE', targets: 'deleteTempFiles.groovy'
							}
						}
					}
				}
			/$.stripIndent())
		}
	}
}

