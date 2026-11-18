package com.example.whatsappui.data

data class ChatPreview(
    val name: String,
    val message: String,
    val time: String,
    val unreadCount: Int = 0,
    val isPinned: Boolean = false,
    val isMuted: Boolean = false,
    val isGroup: Boolean = false,
    val isOutgoing: Boolean = true,
    val isRead: Boolean = true
)

object MockData {
    val chats = listOf(
        ChatPreview("Mamá", "¡Hola hijo! ¿Cómo estás?", "12:45", unreadCount = 2, isPinned = true, isOutgoing = false, isRead = false),
        ChatPreview("Grupo Familia 🏠", "Papá: Nos vemos el domingo a comer.", "11:30", unreadCount = 5, isPinned = true, isGroup = true, isOutgoing = false, isRead = false),
        ChatPreview("Carlos Android", "¿Revisaste el PR de la pantalla principal?", "Ayer", unreadCount = 0, isPinned = true, isMuted = true, isOutgoing = true, isRead = true),
        ChatPreview("Ana Pérez", "Muchas gracias por la ayuda con Compose.", "Ayer", unreadCount = 1, isOutgoing = false, isRead = false),
        ChatPreview("Trabajo - Devs", "Reunión de equipo a las 10:00 AM", "Lunes", unreadCount = 0, isGroup = true, isOutgoing = true, isRead = true),
        ChatPreview("Sofía Gómez", "¿Nos tomamos un café más tarde?", "12/10/24", unreadCount = 0, isOutgoing = true, isRead = true),
        ChatPreview("Pedro Gómez", "Te mandé el documento por correo.", "10/10/24", unreadCount = 0, isOutgoing = false, isRead = true),
        ChatPreview("Lucía Martínez", "¡Feliz cumpleaños! 🎉", "05/10/24", unreadCount = 0, isOutgoing = true, isRead = true),
        ChatPreview("Estudio de Inglés", "Próxima clase el martes.", "01/10/24", unreadCount = 0, isGroup = true, isOutgoing = false, isRead = true),
        ChatPreview("Jorge Luis", "Perfecto, quedamos así entonces.", "28/09/24", unreadCount = 0, isOutgoing = true, isRead = true),
        ChatPreview("Soporte Técnico", "Su ticket ha sido resuelto.", "25/09/24", unreadCount = 0, isOutgoing = false, isRead = true),
        ChatPreview("María Elena", "¿Tienes el contacto de Juan?", "20/09/24", unreadCount = 0, isOutgoing = true, isRead = true)
    )
}
