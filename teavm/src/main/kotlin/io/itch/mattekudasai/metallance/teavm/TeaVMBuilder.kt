package io.itch.mattekudasai.metallance.teavm

import java.io.File
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuildConfiguration
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuilder
import com.github.xpenatan.gdx.backends.teavm.config.plugins.TeaReflectionSupplier
import com.github.xpenatan.gdx.backends.teavm.gen.SkipClass

/** Builds the TeaVM/HTML application. */
@SkipClass
object TeaVMBuilder {
    @JvmStatic fun main(arguments: Array<String>) {
        val teaBuildConfiguration = TeaBuildConfiguration().apply {
            assetsPath.add(File("../assets"))
            webappPath = File("build/dist").canonicalPath
            showLoadingLogo = false
            // Register any extra classpath assets here:
            // additionalAssetsClasspathFiles += "io/itch/mattekudasai/metallance/asset.extension"
        }

        // Register any classes or packages that require reflection here:
        // TeaReflectionSupplier.addReflectionClass("io.itch.mattekudasai.metallance.reflect")

        val tool = TeaBuilder.config(teaBuildConfiguration)
        tool.mainClass = "io.itch.mattekudasai.metallance.teavm.TeaVMLauncher"
        TeaBuilder.build(tool)
    }
}
