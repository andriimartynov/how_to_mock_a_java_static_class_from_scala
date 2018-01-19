package org.andrii.examples

import net.tachtler.browscap4j.{Browscap4jBean, Browscap4jDataBean, Browscap4jFileReader}

class MyCustomBrowscap4jComponent(
                                   browscap4jDataBean: Browscap4jDataBean
                                 ) {
  def determineBrowscap4jCapabilities(
                                       userAgentString: String
                                     ): Browscap4jBean =
    Browscap4jFileReader.determineBrowscap4jCapabilities(browscap4jDataBean, userAgentString)
}
