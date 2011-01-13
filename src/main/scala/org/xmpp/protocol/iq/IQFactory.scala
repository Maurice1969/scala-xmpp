package org.xmpp
{
	package protocol.iq
	{
		import scala.collection._
		import scala.xml._
		
		import org.xmpp.protocol._
		import org.xmpp.protocol.extensions._
		
		import org.xmpp.protocol.Protocol._
		
		object IQFactory //extends StanzaFactory[IQ]
		{
			def create(xml:Node):IQ =
			{
				require("iq" == xml.label)
				
				(xml \ "@type").text match
				{
					// FIXME, use the enum values (attribute stanzaType) instead of stanzaTypeName, getting compilation error even with implicict cast
					case Get.stanzaTypeName => Get(xml) 
					case Set.stanzaTypeName => Set(xml)
					case Result.stanzaTypeName => Result(xml) 
					case Error.stanzaTypeName => Error(xml)
					case _ => throw new Exception("unknown iq stanza") // TODO, give a more detailed error message here
				}
			}
		}
		
	}
}
