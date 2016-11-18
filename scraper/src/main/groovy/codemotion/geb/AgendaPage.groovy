package codemotion.geb

import codemotion.Talk
import geb.Page

class AgendaPage extends Page {
    static url = 'agenda.html#5732408326356992'

    static content = {
        selectedDayTab { $('.ka-tab-li a.selected') }
        dayTabs(wait: true) { $('.ka-tab-li a') }
        dayTab { i -> $('.ka-tab-li a', i) }
        cells(wait: true) { $('td') }
        talks(wait: true) { $('.talk') }
        talkRows(wait: true) { $('.ka-table-tr') }
        talkRow(wait: true) { i -> $('.ka-table-tr', i).module(new TalkRowModule(tracks())) }
        talkLinks { $('a.ka-talk-title') }
        talkLink {  i -> $('a.ka-talk-title', i) }
        trackThs { $('thead .ka-table-th') }
        trackTh { i -> $('thead .ka-table-th', i) }
    }

    List<String> tracks() {
        def tracks = []
        for ( int i = 0;  i < trackThs.size();  i++ ) {
            def text = trackTh(i).text()
            if ( text ) {
                tracks << text
            }
        }
        tracks
    }

    Set<Talk> talks() {

            def talks = [] as Set<Talk>
            for ( int i = 0;  i < talkRows.size();  i++ ) {
                def modTalkRow = talkRow(i)
                talks += modTalkRow.talks()
            }
            final String day = day()
            talks.each { it.day = day }
            talks
    }

    String day() {
        selectedDayTab.text()
    }
}
