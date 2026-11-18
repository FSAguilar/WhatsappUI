package com.example.whatsappui.calls.model

import androidx.compose.ui.graphics.Color

enum class CallType {
    INCOMING,
    OUTGOING,
    MISSED
}

data class RecentCall(
    val id: String,
    val contactName: String,
    val phoneNumber: String,
    val dateTime: String,
    val callType: CallType,
    val isVideo: Boolean = false,
    val avatarColor: Color,
    val initial: String = contactName.take(1).uppercase()
)

data class Contact(
    val id: String,
    val name: String,
    val status: String,
    val phoneNumber: String,
    val isFrequent: Boolean = false,
    val avatarColor: Color,
    val initial: String = name.take(1).uppercase()
)

data class ScheduledEvent(
    var title: String = "Llamada de Ignacio Cardenas",
    var description: String = "",
    var startDate: String = "mar, 17 de nov",
    var startTime: String = "9:30 a. m.",
    var endDate: String = "mar, 17 de nov",
    var endTime: String = "10:00 a. m.",
    var isVideoCall: Boolean = true,
    var requireApproval: Boolean = false,
    var reminder: String = "15 minutos antes",
    var organizer: String = "Ignacio Cardenas"
)

object CallSampleData {
    private val AvatarColors = listOf(
        Color(0xFFE57373),
        Color(0xFF81C784),
        Color(0xFF64B5F6),
        Color(0xFFFFB74D),
        Color(0xFFBA68C8),
        Color(0xFF4DB6AC),
        Color(0xFFFF8A65),
        Color(0xFFA1887F)
    )

    val sampleRecentCalls = listOf(
        RecentCall(
            id = "1",
            contactName = "Tía Andrea Cárdenas",
            phoneNumber = "+591 76543210",
            dateTime = "Ayer, 7:09 p. m.",
            callType = CallType.OUTGOING,
            isVideo = false,
            avatarColor = AvatarColors[0]
        ),
        RecentCall(
            id = "2",
            contactName = "Mamá",
            phoneNumber = "+591 68040502",
            dateTime = "14 de noviembre, 6:09 p. m.",
            callType = CallType.MISSED,
            isVideo = false,
            avatarColor = AvatarColors[1]
        ),
        RecentCall(
            id = "3",
            contactName = "Mamá",
            phoneNumber = "+591 68040502",
            dateTime = "14 de noviembre, 12:20 p. m.",
            callType = CallType.OUTGOING,
            isVideo = false,
            avatarColor = AvatarColors[1]
        ),
        RecentCall(
            id = "4",
            contactName = "Daysi Fuentes",
            phoneNumber = "+591 71234567",
            dateTime = "14 de noviembre, 11:50 a. m.",
            callType = CallType.MISSED,
            isVideo = true,
            avatarColor = AvatarColors[2]
        ),
        RecentCall(
            id = "5",
            contactName = "Abuelita Rosa",
            phoneNumber = "+591 72345678",
            dateTime = "9 de noviembre, 12:24 p. m.",
            callType = CallType.OUTGOING,
            isVideo = false,
            avatarColor = AvatarColors[3]
        ),
        RecentCall(
            id = "6",
            contactName = "Papá Miguel",
            phoneNumber = "+591 73456789",
            dateTime = "5 de noviembre, 8:09 p. m.",
            callType = CallType.MISSED,
            isVideo = false,
            avatarColor = AvatarColors[4]
        ),
        RecentCall(
            id = "7",
            contactName = "Paolo Mendoza",
            phoneNumber = "+51 987654321",
            dateTime = "5 de noviembre, 8:30 a. m.",
            callType = CallType.OUTGOING,
            isVideo = false,
            avatarColor = AvatarColors[5]
        ),
        RecentCall(
            id = "8",
            contactName = "Carlos Morales",
            phoneNumber = "+591 74567890",
            dateTime = "4 de noviembre, 5:10 p. m.",
            callType = CallType.INCOMING,
            isVideo = true,
            avatarColor = AvatarColors[6]
        )
    )

    val sampleContacts = listOf(
        Contact(
            id = "c1",
            name = "Tía Andrea Cárdenas",
            status = "¡Hola! Estoy usando WhatsApp.",
            phoneNumber = "+591 76543210",
            isFrequent = true,
            avatarColor = AvatarColors[0]
        ),
        Contact(
            id = "c2",
            name = "Mamá",
            status = "Muy feliz con la bendición de Dios",
            phoneNumber = "+591 68040502",
            isFrequent = true,
            avatarColor = AvatarColors[1]
        ),
        Contact(
            id = "c3",
            name = "Daysi Fuentes",
            status = "En el trabajo",
            phoneNumber = "+591 71234567",
            isFrequent = true,
            avatarColor = AvatarColors[2]
        ),
        Contact(
            id = "c4",
            name = "Abuelita Rosa",
            status = "Bendecida por el Señor",
            phoneNumber = "+591 72345678",
            isFrequent = true,
            avatarColor = AvatarColors[3]
        ),
        Contact(
            id = "c5",
            name = "Papá Miguel",
            status = "Disponible",
            phoneNumber = "+591 73456789",
            isFrequent = true,
            avatarColor = AvatarColors[4]
        ),
        Contact(
            id = "c6",
            name = "Alejandro Vega",
            status = " ✨ ",
            phoneNumber = "+591 75678901",
            isFrequent = true,
            avatarColor = AvatarColors[5]
        ),
        Contact(
            id = "c7",
            name = "Joshua Silva",
            status = "Disponible",
            phoneNumber = "+591 76789012",
            isFrequent = true,
            avatarColor = AvatarColors[6]
        ),
        Contact(
            id = "c8",
            name = "Bernardo Flores",
            status = "Solo llamadas de emergencia",
            phoneNumber = "+591 77890123",
            isFrequent = false,
            avatarColor = AvatarColors[7]
        ),
        Contact(
            id = "c9",
            name = "Camila Rios",
            status = "En el gimnasio",
            phoneNumber = "+591 78901234",
            isFrequent = false,
            avatarColor = AvatarColors[0]
        ),
        Contact(
            id = "c10",
            name = "Daniel Gutierrez",
            status = "Ocupado",
            phoneNumber = "+591 79012345",
            isFrequent = false,
            avatarColor = AvatarColors[1]
        )
    )
}
