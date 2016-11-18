# Run Tests

## Firefox

````
./gradlew test -Dgeb.env=firefox scraper:test
````

## phantomJs

````
./gradlew -Dgeb.env=phantomJs -Dphantomjs.binary.path=/Users/sdelamo/Applications/phantomjs-2.1.1-macosx/bin/phantomjs scraper:test
````