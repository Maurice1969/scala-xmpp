package org.simbit.xmpp
{
	package protocol.message
	{
		import scala.collection._
		import scala.xml._
		
		import org.simbit.xmpp.protocol._
		import org.simbit.xmpp.protocol.Protocol._
		
		object Chat
		{	
			val messageType = MessageTypeEnumeration.Chat
			val messageTypeName = messageType.toString // FIXME, this should be done automatically via implicit def, but does not work for enum values for some reson
			
			def apply(to:Option[JID], from:Option[JID], body:Option[String]):Chat = apply(None, to, from, None, body, None, None)
			
			def apply(id:Option[String], to:Option[JID], from:Option[JID], body:Option[String]):Chat = apply(id, to, from, None, body, None, None)
				
			def apply(id:Option[String], to:Option[JID], from:Option[JID], subject:Option[String], body:Option[String]):Chat = apply(id, to, from, subject, body, None, None)
					
			def apply(id:Option[String], to:Option[JID], from:Option[JID], subject:Option[String], body:Option[String], thread:Option[String], extension:Option[Extension]):Chat =
			{
				val xml = Message.build(messageType, id, to, from, subject, body, thread, extension)
				return apply(xml)
			}
						
			def apply(xml:Node):Chat = new Chat(xml)
		}
		
		class Chat(xml:Node) extends Message(xml, Chat.messageType)
		{
		}

	}
}