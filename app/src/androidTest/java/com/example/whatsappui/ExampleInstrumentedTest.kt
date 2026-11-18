package com.example.whatsappui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun principal_chat_info_y_llamadas_estan_conectadas() {
        composeRule.onNodeWithText("Mamá").performClick()
        composeRule.onNodeWithContentDescription("Información de Mamá").performClick()
        composeRule.onNodeWithText("+591 7123 4567").assertIsDisplayed()

        composeRule.onNodeWithContentDescription("Volver").performClick()
        composeRule.onNodeWithContentDescription("Atrás").performClick()

        composeRule.onNodeWithText("Llamadas").performClick()
        composeRule.onNodeWithText("Recientes").assertIsDisplayed()

        composeRule.onNodeWithText("Programar").performClick()
        composeRule.onNodeWithText("Crea un evento").assertIsDisplayed()
        composeRule.onNodeWithContentDescription("Volver").performClick()

        composeRule.onNodeWithText("Teclado").performClick()
        composeRule.onNodeWithText("1").assertIsDisplayed()
        composeRule.onNodeWithContentDescription("Volver").performClick()

        composeRule.onNodeWithText("Tía Andrea Cárdenas").performClick()
        composeRule.onNodeWithText("Info. de la llamada").assertIsDisplayed()
        composeRule.onNodeWithContentDescription("Volver").performClick()

        composeRule.onNodeWithContentDescription("Nueva llamada").performClick()
        composeRule.onNodeWithText("Contactos").assertIsDisplayed()
    }
}
