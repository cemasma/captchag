# captchag
CaptchaG is a simple captcha generator.

# Download

```xml
<repositories>
	<repository>
		<id>captchag</id>
		<url>https://mymavenrepo.com/repo/rx3leYorZpXFK79yi2qD/</url>
  </repository>
</repositories>
  
<dependencies>
  <dependency>
    <groupId>io.github.cemasma</groupId>
    <artifactId>captchag</artifactId>
    <version>1.0-SNAPSHOT</version>
  </dependency>
</dependencies>
```

# Sample Usage in Spring Boot
You can access and try that sample in demo directory.
```java
	
@RequestMapping(path = "/test", method = RequestMethod.GET)
public String hello(Model model, HttpServletRequest request) throws IOException {
	captchaGenerator = new CaptchaGenerator(5);
	captchaGenerator.drawRandomCharacters();
	captchaGenerator.save();

	return "test";
}

@RequestMapping(path = "/test", method = RequestMethod.POST)
public String hello(@RequestParam(name = "captchaCode", required = true) String captchaCode) {

	if(!captchaGenerator.check(captchaCode)) {
		// return error
		return "error";
	}
	return "redirect:test";
}
  
// You can use the generated image by this url.
@GetMapping(value = "/image")
public @ResponseBody byte[] getImage(HttpServletRequest request) throws IOException {
	return captchaGenerator.getImage();
}

```
