package org.andrii.examples

import net.tachtler.browscap4j.{Browscap4jBean, Browscap4jDataBean, Browscap4jFileReader}
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.{PowerMockIgnore, PrepareForTest}
import org.powermock.modules.junit4.PowerMockRunner
import org.scalatest._
import org.scalatest.junit.JUnitSuite
import org.scalatest.mockito.MockitoSugar

@PrepareForTest(Array(classOf[Browscap4jFileReader]))
@RunWith(classOf[PowerMockRunner])
@PowerMockIgnore(Array("javax.management.*"))
class MyCustomBrowscap4jComponentTest
  extends JUnitSuite
    with Matchers
    with MockitoSugar {

  val browscap4jDataBean = mock[Browscap4jDataBean]
  val cut = new MyCustomBrowscap4jComponent((browscap4jDataBean))

  @Test
  def example(): Unit = {
    val userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/604.4.7 (KHTML, like Gecko) Version/11.0.2 Safari/604.4.7"
    val browscap4jBean = mock[Browscap4jBean]
    PowerMockito.mockStatic(classOf[Browscap4jFileReader])
    Mockito.when(Browscap4jFileReader.determineBrowscap4jCapabilities(browscap4jDataBean, userAgent)).thenReturn(browscap4jBean)

    val result = cut.determineBrowscap4jCapabilities(userAgent)
    result should be(browscap4jBean)
  }
}
