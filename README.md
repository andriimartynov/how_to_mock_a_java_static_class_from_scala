# How to mock a java static class from scala.


[Code sample:](https://github.com/andriimartynov/how_to_mock_a_java_static_class_from_scala/blob/master/src/test/org/andrii/examples/MyCustomBrowscap4jComponentTest.scala)

```
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
```