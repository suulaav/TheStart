package np.com.suulaav.backend.security.context;



public class ApplicationRequestContextHolder {

  private static ThreadLocal<ApplicationContext> CONTEXT = new ThreadLocal<>();

  public static void setContext(ApplicationContext applicationContext) {
    CONTEXT.set(applicationContext);
  }

  public static ApplicationContext get() {
    ApplicationContext appContext = CONTEXT.get();
    if (appContext == null) {
      appContext = new ApplicationContext();
    }
    return appContext;
  }

  public static void clear() {
    CONTEXT.remove();
  }
}
