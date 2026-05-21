/*
 * Copyright 2010-2026 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.targets.wasm.binaryen

import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.process.ExecOperations
import org.gradle.process.ExecSpec
import org.gradle.workers.WorkAction
import org.gradle.workers.WorkParameters
import org.jetbrains.kotlin.gradle.utils.getFile
import javax.inject.Inject

internal abstract class BinaryenWorkAction : WorkAction<BinaryenWorkAction.BinaryenWorkParameters> {
    internal interface BinaryenWorkParameters : WorkParameters {
        val executable: Property<String>
        val workingDir: DirectoryProperty
        val args: ListProperty<String>
        val inputFile: RegularFileProperty
        val outputFile: RegularFileProperty
        val logFile: RegularFileProperty
    }

    @get:Inject
    abstract val execOperations: ExecOperations

    override fun execute() {
        val logFile = parameters.logFile
        if (!logFile.isPresent) {
            execOperations.exec {
                it.commonExecConfiguration()
            }
            return
        }

        logFile.getFile().outputStream().use { output ->
            execOperations.exec {
                it.commonExecConfiguration()

                it.standardOutput = output
                it.errorOutput = output
            }
        }
    }

    private fun ExecSpec.commonExecConfiguration() {
        executable = parameters.executable.get()
        workingDir = parameters.workingDir.getFile()
        args = parameters.args.get() +
                parameters.inputFile.getFile().absolutePath +
                "-o" +
                parameters.outputFile.getFile().absolutePath
    }
}
