package net.renerte.smoofapi
import net.fabricmc.api.ModInitializer

@Suppress("UNUSED")
object SmoofApi: ModInitializer {
    private const val MOD_ID = "smoofapi"
    override fun onInitialize() {
        println("[SmoofApi] Library loaded successfully ;)")
    }
}