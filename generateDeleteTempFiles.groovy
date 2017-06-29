pipelineJob('Delete temp files pipeline') {
	definition {
		cps {
			script(readFileFromWorkspace('Jenkinsfile'))
		}
	}
}

