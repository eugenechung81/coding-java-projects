package org.jboss.errai.ioc.client;

import foo.bar.ui.client.local.ErraiIocTestHelper;
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
  private native static void foo_bar_ui_client_local_ErraiIocTestHelper_client(ErraiIocTestHelper instance, HelloWorldClient value) /*-{
    instance.@foo.bar.ui.client.local.ErraiIocTestHelper::client = value;
  }-*/;

  private native static void org_jboss_errai_ioc_client_api_builtin_DisposerProvider_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void foo_bar_ui_client_local_ErraiIocTestHelper_bus(ErraiIocTestHelper instance, MessageBus value) /*-{
    instance.@foo.bar.ui.client.local.ErraiIocTestHelper::bus = value;
  }-*/;

  private native static void foo_bar_ui_client_local_HelloWorldClient_bus(HelloWorldClient instance, MessageBus value) /*-{
    instance.@foo.bar.ui.client.local.HelloWorldClient::bus = value;
  }-*/;

  public native static void foo_bar_ui_client_local_ErraiIocTestHelper_saveStaticReference(ErraiIocTestHelper instance) /*-{
    instance.@foo.bar.ui.client.local.ErraiIocTestHelper::saveStaticReference()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
    CreationalContext context = injContext.getRootContext();
    final CreationalCallback<CallerProvider> inj3743_CallerProvider_creationalCallback = new CreationalCallback<CallerProvider>() {
      public CallerProvider getInstance(final CreationalContext context) {
        Class beanType = CallerProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final CallerProvider inj3738_CallerProvider = new CallerProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3738_CallerProvider);
        return inj3738_CallerProvider;
      }
    };
    final CallerProvider inj3738_CallerProvider = inj3743_CallerProvider_creationalCallback.getInstance(context);
    final CreationalCallback<RequestDispatcherProvider> inj3744_RequestDispatcherProvider_creationalCallback = new CreationalCallback<RequestDispatcherProvider>() {
      public RequestDispatcherProvider getInstance(final CreationalContext context) {
        Class beanType = RequestDispatcherProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final RequestDispatcherProvider inj3736_RequestDispatcherProvider = new RequestDispatcherProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3736_RequestDispatcherProvider);
        return inj3736_RequestDispatcherProvider;
      }
    };
    final RequestDispatcherProvider inj3736_RequestDispatcherProvider = inj3744_RequestDispatcherProvider_creationalCallback.getInstance(context);
    final CreationalCallback<SenderProvider> inj3745_SenderProvider_creationalCallback = new CreationalCallback<SenderProvider>() {
      public SenderProvider getInstance(final CreationalContext context) {
        Class beanType = SenderProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final SenderProvider inj3742_SenderProvider = new SenderProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3742_SenderProvider);
        return inj3742_SenderProvider;
      }
    };
    final SenderProvider inj3742_SenderProvider = inj3745_SenderProvider_creationalCallback.getInstance(context);
    final CreationalCallback<RootPanelProvider> inj3746_RootPanelProvider_creationalCallback = new CreationalCallback<RootPanelProvider>() {
      public RootPanelProvider getInstance(final CreationalContext context) {
        Class beanType = RootPanelProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final RootPanelProvider inj3730_RootPanelProvider = new RootPanelProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3730_RootPanelProvider);
        return inj3730_RootPanelProvider;
      }
    };
    final RootPanelProvider inj3730_RootPanelProvider = inj3746_RootPanelProvider_creationalCallback.getInstance(context);
    final CreationalCallback<IOCBeanManagerProvider> inj3747_IOCBeanManagerProvider_creationalCallback = new CreationalCallback<IOCBeanManagerProvider>() {
      public IOCBeanManagerProvider getInstance(final CreationalContext context) {
        Class beanType = IOCBeanManagerProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final IOCBeanManagerProvider inj3732_IOCBeanManagerProvider = new IOCBeanManagerProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3732_IOCBeanManagerProvider);
        return inj3732_IOCBeanManagerProvider;
      }
    };
    final IOCBeanManagerProvider inj3732_IOCBeanManagerProvider = inj3747_IOCBeanManagerProvider_creationalCallback.getInstance(context);
    final CreationalCallback<MessageBusProvider> inj3748_MessageBusProvider_creationalCallback = new CreationalCallback<MessageBusProvider>() {
      public MessageBusProvider getInstance(final CreationalContext context) {
        Class beanType = MessageBusProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final MessageBusProvider inj3728_MessageBusProvider = new MessageBusProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3728_MessageBusProvider);
        return inj3728_MessageBusProvider;
      }
    };
    final InitializationCallback<HelloWorldClient> init_inj3418_HelloWorldClient = new InitializationCallback<HelloWorldClient>() {
      public void init(final HelloWorldClient obj) {
        obj.buildUI();
      }
    };
    final MessageBusProvider inj3728_MessageBusProvider = inj3748_MessageBusProvider_creationalCallback.getInstance(context);
    final CreationalCallback<HelloWorldClient> inj3749_HelloWorldClient_creationalCallback = new CreationalCallback<HelloWorldClient>() {
      public HelloWorldClient getInstance(final CreationalContext context) {
        Class beanType = HelloWorldClient.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final HelloWorldClient inj3418_HelloWorldClient = new HelloWorldClient();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3418_HelloWorldClient);
        foo_bar_ui_client_local_HelloWorldClient_bus(inj3418_HelloWorldClient, inj3728_MessageBusProvider.get());
        context.addInitializationCallback(inj3418_HelloWorldClient, init_inj3418_HelloWorldClient);
        return inj3418_HelloWorldClient;
      }
    };
    final HelloWorldClient inj3418_HelloWorldClient = inj3749_HelloWorldClient_creationalCallback.getInstance(context);
    final CreationalCallback<DisposerProvider> inj3750_DisposerProvider_creationalCallback = new CreationalCallback<DisposerProvider>() {
      public DisposerProvider getInstance(final CreationalContext context) {
        Class beanType = DisposerProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final DisposerProvider inj3734_DisposerProvider = new DisposerProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3734_DisposerProvider);
        org_jboss_errai_ioc_client_api_builtin_DisposerProvider_beanManager(inj3734_DisposerProvider, inj3732_IOCBeanManagerProvider.get());
        return inj3734_DisposerProvider;
      }
    };
    final DisposerProvider inj3734_DisposerProvider = inj3750_DisposerProvider_creationalCallback.getInstance(context);
    final CreationalCallback<InitBallotProvider> inj3751_InitBallotProvider_creationalCallback = new CreationalCallback<InitBallotProvider>() {
      public InitBallotProvider getInstance(final CreationalContext context) {
        Class beanType = InitBallotProvider.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final InitBallotProvider inj3740_InitBallotProvider = new InitBallotProvider();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3740_InitBallotProvider);
        return inj3740_InitBallotProvider;
      }
    };
    final InitializationCallback<ErraiIocTestHelper> init_inj3419_ErraiIocTestHelper = new InitializationCallback<ErraiIocTestHelper>() {
      public void init(final ErraiIocTestHelper obj) {
        foo_bar_ui_client_local_ErraiIocTestHelper_saveStaticReference(obj);
      }
    };
    final InitBallotProvider inj3740_InitBallotProvider = inj3751_InitBallotProvider_creationalCallback.getInstance(context);
    final CreationalCallback<ErraiIocTestHelper> inj3752_ErraiIocTestHelper_creationalCallback = new CreationalCallback<ErraiIocTestHelper>() {
      public ErraiIocTestHelper getInstance(final CreationalContext context) {
        Class beanType = ErraiIocTestHelper.class;
        Annotation[] qualifiers = new Annotation[] { new Any() {
            public Class annotationType() {
              return Any.class;
            }
        } };
        final ErraiIocTestHelper inj3419_ErraiIocTestHelper = new ErraiIocTestHelper();
        BeanRef beanRef = context.getBeanReference(beanType, qualifiers);
        context.addBean(beanRef, inj3419_ErraiIocTestHelper);
        foo_bar_ui_client_local_ErraiIocTestHelper_client(inj3419_ErraiIocTestHelper, inj3418_HelloWorldClient);
        foo_bar_ui_client_local_ErraiIocTestHelper_bus(inj3419_ErraiIocTestHelper, inj3728_MessageBusProvider.get());
        context.addInitializationCallback(inj3419_ErraiIocTestHelper, init_inj3419_ErraiIocTestHelper);
        return inj3419_ErraiIocTestHelper;
      }
    };
    final ErraiIocTestHelper inj3419_ErraiIocTestHelper = inj3752_ErraiIocTestHelper_creationalCallback.getInstance(context);
    injContext.addBean(CallerProvider.class, inj3743_CallerProvider_creationalCallback, inj3738_CallerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3743_CallerProvider_creationalCallback, inj3738_CallerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(RequestDispatcherProvider.class, inj3744_RequestDispatcherProvider_creationalCallback, inj3736_RequestDispatcherProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3744_RequestDispatcherProvider_creationalCallback, inj3736_RequestDispatcherProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(SenderProvider.class, inj3745_SenderProvider_creationalCallback, inj3742_SenderProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3745_SenderProvider_creationalCallback, inj3742_SenderProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(RootPanelProvider.class, inj3746_RootPanelProvider_creationalCallback, inj3730_RootPanelProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3746_RootPanelProvider_creationalCallback, inj3730_RootPanelProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(IOCBeanManagerProvider.class, inj3747_IOCBeanManagerProvider_creationalCallback, inj3732_IOCBeanManagerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3747_IOCBeanManagerProvider_creationalCallback, inj3732_IOCBeanManagerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(MessageBusProvider.class, inj3748_MessageBusProvider_creationalCallback, inj3728_MessageBusProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(Provider.class, inj3748_MessageBusProvider_creationalCallback, inj3728_MessageBusProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(HelloWorldClient.class, inj3749_HelloWorldClient_creationalCallback, inj3418_HelloWorldClient, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(DisposerProvider.class, inj3750_DisposerProvider_creationalCallback, inj3734_DisposerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3750_DisposerProvider_creationalCallback, inj3734_DisposerProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(InitBallotProvider.class, inj3751_InitBallotProvider_creationalCallback, inj3740_InitBallotProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ContextualTypeProvider.class, inj3751_InitBallotProvider_creationalCallback, inj3740_InitBallotProvider, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    injContext.addBean(ErraiIocTestHelper.class, inj3752_ErraiIocTestHelper_creationalCallback, inj3419_ErraiIocTestHelper, BuiltInQualifiers.DEFAULT_QUALIFIERS);
    return injContext;
  }
}