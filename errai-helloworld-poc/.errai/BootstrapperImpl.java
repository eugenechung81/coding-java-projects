package org.jboss.errai.ioc.client;

import foo.bar.ui.client.local.HelloWorldClient;
import java.lang.annotation.Annotation;
import javax.inject.Provider;
import org.jboss.errai.bus.client.framework.MessageBus;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.ioc.client.api.builtin.RequestDispatcherProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.api.builtin.SenderProvider;
import org.jboss.errai.ioc.client.api.qualifiers.Any;
import org.jboss.errai.ioc.client.api.qualifiers.BuiltInQualifiers;
import org.jboss.errai.ioc.client.container.BeanRef;
import org.jboss.errai.ioc.client.container.CreationalCallback;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;

public class BootstrapperImpl implements Bootstrapper {
  private native static void org_jboss_errai_ioc_client_api_builtin_DisposerProvider_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void foo_bar_ui_client_local_HelloWorldClient_bus(HelloWorldClient instance, MessageBus value) /*-{
    instance.@foo.bar.ui.client.local.HelloWorldClient::bus = value;
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
    CreationalContext context = injContext.getRootContext();
    final CreationalCallback<CallerProvider> inj3396_CallerProvider_creationalCallback = new CreationalCallback<CallerProvider>() {
      public CallerProvider getInstance(final CreationalContext context) {
        Class beanType = CallerProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final CallerProvider inj3391_CallerProvider = new CallerProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3391_CallerProvider);
        return inj3391_CallerProvider;
      }
    };
    final CallerProvider inj3391_CallerProvider = inj3396_CallerProvider_creationalCallback.getInstance(context);
    final CreationalCallback<RequestDispatcherProvider> inj3397_RequestDispatcherProvider_creationalCallback = new CreationalCallback<RequestDispatcherProvider>() {
      public RequestDispatcherProvider getInstance(final CreationalContext context) {
        Class beanType = RequestDispatcherProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final RequestDispatcherProvider inj3389_RequestDispatcherProvider = new RequestDispatcherProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3389_RequestDispatcherProvider);
        return inj3389_RequestDispatcherProvider;
      }
    };
    final RequestDispatcherProvider inj3389_RequestDispatcherProvider = inj3397_RequestDispatcherProvider_creationalCallback.getInstance(context);
    final CreationalCallback<SenderProvider> inj3398_SenderProvider_creationalCallback = new CreationalCallback<SenderProvider>() {
      public SenderProvider getInstance(final CreationalContext context) {
        Class beanType = SenderProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final SenderProvider inj3383_SenderProvider = new SenderProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3383_SenderProvider);
        return inj3383_SenderProvider;
      }
    };
    final SenderProvider inj3383_SenderProvider = inj3398_SenderProvider_creationalCallback.getInstance(context);
    final CreationalCallback<RootPanelProvider> inj3399_RootPanelProvider_creationalCallback = new CreationalCallback<RootPanelProvider>() {
      public RootPanelProvider getInstance(final CreationalContext context) {
        Class beanType = RootPanelProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final RootPanelProvider inj3387_RootPanelProvider = new RootPanelProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3387_RootPanelProvider);
        return inj3387_RootPanelProvider;
      }
    };
    final RootPanelProvider inj3387_RootPanelProvider = inj3399_RootPanelProvider_creationalCallback.getInstance(context);
    final CreationalCallback<MessageBusProvider> inj3400_MessageBusProvider_creationalCallback = new CreationalCallback<MessageBusProvider>() {
      public MessageBusProvider getInstance(final CreationalContext context) {
        Class beanType = MessageBusProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final MessageBusProvider inj3393_MessageBusProvider = new MessageBusProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3393_MessageBusProvider);
        return inj3393_MessageBusProvider;
      }
    };
    final MessageBusProvider inj3393_MessageBusProvider = inj3400_MessageBusProvider_creationalCallback.getInstance(context);
    final CreationalCallback<IOCBeanManagerProvider> inj3401_IOCBeanManagerProvider_creationalCallback = new CreationalCallback<IOCBeanManagerProvider>() {
      public IOCBeanManagerProvider getInstance(final CreationalContext context) {
        Class beanType = IOCBeanManagerProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final IOCBeanManagerProvider inj3385_IOCBeanManagerProvider = new IOCBeanManagerProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3385_IOCBeanManagerProvider);
        return inj3385_IOCBeanManagerProvider;
      }
    };
    final InitializationCallback<HelloWorldClient> init_inj3079_HelloWorldClient = new InitializationCallback<HelloWorldClient>() {
      public void init(final HelloWorldClient obj) {
        obj.buildUI();
      }
    };
    final IOCBeanManagerProvider inj3385_IOCBeanManagerProvider = inj3401_IOCBeanManagerProvider_creationalCallback.getInstance(context);
    final CreationalCallback<HelloWorldClient> inj3402_HelloWorldClient_creationalCallback = new CreationalCallback<HelloWorldClient>() {
      public HelloWorldClient getInstance(final CreationalContext context) {
        Class beanType = HelloWorldClient.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final HelloWorldClient inj3079_HelloWorldClient = new HelloWorldClient();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3079_HelloWorldClient);
        foo_bar_ui_client_local_HelloWorldClient_bus(inj3079_HelloWorldClient, inj3393_MessageBusProvider.get());
        context.addInitializationCallback(inj3079_HelloWorldClient, init_inj3079_HelloWorldClient);
        return inj3079_HelloWorldClient;
      }
    };
    final HelloWorldClient inj3079_HelloWorldClient = inj3402_HelloWorldClient_creationalCallback.getInstance(context);
    final CreationalCallback<DisposerProvider> inj3403_DisposerProvider_creationalCallback = new CreationalCallback<DisposerProvider>() {
      public DisposerProvider getInstance(final CreationalContext context) {
        Class beanType = DisposerProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final DisposerProvider inj3381_DisposerProvider = new DisposerProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3381_DisposerProvider);
        org_jboss_errai_ioc_client_api_builtin_DisposerProvider_beanManager(inj3381_DisposerProvider, inj3385_IOCBeanManagerProvider.get());
        return inj3381_DisposerProvider;
      }
    };
    final DisposerProvider inj3381_DisposerProvider = inj3403_DisposerProvider_creationalCallback.getInstance(context);
    final CreationalCallback<InitBallotProvider> inj3404_InitBallotProvider_creationalCallback = new CreationalCallback<InitBallotProvider>() {
      public InitBallotProvider getInstance(final CreationalContext context) {
        Class beanType = InitBallotProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final InitBallotProvider inj3395_InitBallotProvider = new InitBallotProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3395_InitBallotProvider);
        return inj3395_InitBallotProvider;
      }
    };
    final InitBallotProvider inj3395_InitBallotProvider = inj3404_InitBallotProvider_creationalCallback.getInstance(context);
    injContext.addBean(CallerProvider.class, inj3396_CallerProvider_creationalCallback, inj3391_CallerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3396_CallerProvider_creationalCallback, inj3391_CallerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(RequestDispatcherProvider.class, inj3397_RequestDispatcherProvider_creationalCallback, inj3389_RequestDispatcherProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3397_RequestDispatcherProvider_creationalCallback, inj3389_RequestDispatcherProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(SenderProvider.class, inj3398_SenderProvider_creationalCallback, inj3383_SenderProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3398_SenderProvider_creationalCallback, inj3383_SenderProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(RootPanelProvider.class, inj3399_RootPanelProvider_creationalCallback, inj3387_RootPanelProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3399_RootPanelProvider_creationalCallback, inj3387_RootPanelProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(MessageBusProvider.class, inj3400_MessageBusProvider_creationalCallback, inj3393_MessageBusProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3400_MessageBusProvider_creationalCallback, inj3393_MessageBusProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(IOCBeanManagerProvider.class, inj3401_IOCBeanManagerProvider_creationalCallback, inj3385_IOCBeanManagerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3401_IOCBeanManagerProvider_creationalCallback, inj3385_IOCBeanManagerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(HelloWorldClient.class, inj3402_HelloWorldClient_creationalCallback, inj3079_HelloWorldClient, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(DisposerProvider.class, inj3403_DisposerProvider_creationalCallback, inj3381_DisposerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3403_DisposerProvider_creationalCallback, inj3381_DisposerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(InitBallotProvider.class, inj3404_InitBallotProvider_creationalCallback, inj3395_InitBallotProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3404_InitBallotProvider_creationalCallback, inj3395_InitBallotProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    return injContext;
  }
}