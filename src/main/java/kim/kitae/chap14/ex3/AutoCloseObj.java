package kim.kitae.chap14.ex3;

public class AutoCloseObj implements AutoCloseable{
    
    @Override
    public void close() throws Exception {
        System.out.println("리소스가 close( ) 되었습니다");
    }
}
