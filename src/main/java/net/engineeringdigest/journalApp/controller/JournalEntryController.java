//package net.engineeringdigest.journalApp.controller;
//
//import net.engineeringdigest.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private Map<String,JournalEntry> map = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getJournalEntries() {
//        return new ArrayList<>(map.values());
//    }
//
//@PostMapping
//    public boolean addJournalEntry(@RequestBody JournalEntry journalEntry) {
//        map.put(journalEntry.getId(), journalEntry);
//        return true;
//    }
//
//    @GetMapping("entryId/{journalId}")
//    public JournalEntry getJournalEntriesByJournalId(@PathVariable  Long journalId) {
//        return map.get(journalId);
//    }
//
//    @DeleteMapping("entryId/{journalId}")
//    public boolean deleteJournalEntry(@PathVariable Long journalId) {
//        return map.remove(journalId) != null;
//    }
//
//    @PutMapping("entryId/{journalId}")
//    public JournalEntry updateJournalEntryByJournalId(@PathVariable String journalId, @RequestBody JournalEntry journalEntry) {
//     return map.put(journalId, journalEntry);
//    }
//
//
//}
