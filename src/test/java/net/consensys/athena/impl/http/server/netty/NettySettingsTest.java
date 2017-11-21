package net.consensys.athena.impl.http.server.netty;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NettySettingsTest {

  @Test
  public void testIsHttpIfHttpPortSet() {
    NettySettings settings = new NettySettings(empty(), of(8080), empty(), null);
    assertFalse(settings.isDomainSocket());
    assertTrue(settings.isHttp());
    assertFalse(settings.isHttps());
  }

  @Test
  public void testIsHttpsIfHttpsPortSet() {
    NettySettings settings = new NettySettings(empty(), empty(), of(8080), null);
    assertFalse(settings.isDomainSocket());
    assertFalse(settings.isHttp());
    assertTrue(settings.isHttps());
  }

  @Test
  public void testIsDomainIfDomainSocketPathSet() {
    NettySettings settings = new NettySettings(of("/tmp/mysock.ipc"), empty(), empty(), null);
    assertTrue(settings.isDomainSocket());
    assertFalse(settings.isHttp());
    assertFalse(settings.isHttps());
  }
}