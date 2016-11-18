package codemotion

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@ToString(excludes = 'about')
@TupleConstructor
@CompileStatic
class Talk {
    String day
    String track
    String title
    List<Speaker> speakers
    String timetable
    String about
    List<String> tags
}
