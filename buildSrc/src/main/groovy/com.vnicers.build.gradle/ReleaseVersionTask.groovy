package com.vnicers.build.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class ReleaseVersionTask extends DefaultTask {

    @Input
    Boolean release

    @OutputFile
    File destFile

    ReleaseVersionTask() {
        group = 'version'
        description = 'Makes project a release version'
    }

    @TaskAction
    void start() {
        project.version.release = true

        ant.propertyfile(file: destFile) {
            entry(key: 'release', type: 'string', operation: '=', value: 'true')
        }
        logger.quiet "Version: ${project.version}"
    }
}