package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan  // will scan this package and all subpackages
// @ComponentScan("soundsystem")   // scan for particular package
// @ComponentScan(basePackages = "soundsystem")
// @ComponentScan(basePackages = {"soundsystem", "video"})
// @ComponentScan(basePackageClasses = {CompactDisc.class, SgtPeppers.class})  // scans a package(s) where these particular classes are
@ComponentScan(basePackageClasses = BasePackageRootMarkerForComponentScan.class)
public class CDPlayerConfig {
}
