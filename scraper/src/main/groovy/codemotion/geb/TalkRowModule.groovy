package codemotion.geb

import codemotion.Speaker
import codemotion.Talk
import geb.Module

class TalkRowModule extends Module {

    List<String> tracks

    TalkRowModule(List<String> tracks) {
        this.tracks = tracks
    }

    static content = {
        talkCells(wait: true, required: false) { $('td') }
        talkCell(wait: true, required: false) { i -> $('td', i).module(TalkCellModule) }
        talkTimetableCell(required: false) { $('th', 0) }
    }

    String timetable() {
        if ( talkTimetableCell.empty ) {
            return ''
        }

        talkTimetableCell.text()
    }

    Set<Talk> talks() {
        String timetable = timetable()
        def talks = [] as Set<Talk>
        if ( talkCells.empty ) {
            return talks
        }
        for ( int i = 0;  i < talkCells.size();  i++ ) {
            def modTalkCell = talkCell(i)
            def speakers = []
            modTalkCell.speaker().split(', ').each {
                speakers << new Speaker(name: it)
            }

            String track = ( tracks.size() > i ) ? tracks[i] : null
            talks << new Talk(track: track, speakers: speakers, title: modTalkCell.title(), timetable: timetable)
        }

        talks
    }
}
