package codemotion

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString(excludes = 'bio')
@CompileStatic
class Speaker {
    String name
    String twitter
    String url
    String bio
}
