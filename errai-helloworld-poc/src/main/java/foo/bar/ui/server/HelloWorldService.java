package foo.bar.ui.server;

import java.util.Date;

import org.jboss.errai.bus.client.api.Message;
import org.jboss.errai.bus.client.api.MessageCallback;
import org.jboss.errai.bus.client.api.SubscribeListener;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.framework.MessageBus;
import org.jboss.errai.bus.client.framework.RequestDispatcher;
import org.jboss.errai.bus.client.framework.SubscriptionEvent;
import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.common.client.api.tasks.AsyncTask;

import com.google.inject.Inject;

@Service
public class HelloWorldService implements MessageCallback
{
	private volatile AsyncTask task;
	private RequestDispatcher dispatcher;

	@Inject
	public HelloWorldService(final RequestDispatcher dispatcher, final MessageBus bus)
	{
		this.dispatcher = dispatcher;
		bus.addSubscribeListener(new SubscribeListener()
		{

			@Override
			public void onSubscribe(SubscriptionEvent event)
			{
				if (event.getSubject().equals("HelloWorldClient"))
				{
					if (task == null || task.isCancelled())
					{
						// task = MessageBuilder.createMessage().toSubject("HelloWorldClient").command("DateChange").with("Data", "TEST").noErrorHandling()
						// .sendRepeatingWith(dispatcher, TimeUnit.MILLISECONDS, 5000);

					}
				}
			}
		});
	}

	public void callback(Message message)
	{
		MessageBuilder.createConversation(message).subjectProvided().withValue("Hello, World! The server's time is now " + new Date() + ".").done().reply();
		String textMessage = message.get(String.class, "Value");
		MessageBuilder.createMessage().toSubject("HelloWorldClient").command("DateChange").with("Data", textMessage).noErrorHandling().sendNowWith(dispatcher);

	}
}
