package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.JournalEntryRepo;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.Users;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    UserEntryService userEntryService;

    private static  final Logger  logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveEntry(JournalEntry entry, String userName) {
        try {
            Users user = userEntryService.getUserByUserName(userName);
            entry.setEntryDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepo.save(entry);
            user.getJournalEntry().add(saved);
            userEntryService.saveUser(user);
        }
        catch (Exception e) {
           logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveEntry(JournalEntry entry) {
        journalEntryRepo.save(entry);
    }

    public List<JournalEntry> getEntries() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getEntriesByJournalId(ObjectId journalId) {
        return journalEntryRepo.findById(journalId);
    }

    public void deleteEntry(ObjectId journalId) {
        journalEntryRepo.deleteById(journalId);
    }

    public void deleteEntryForUserName(ObjectId journalId, String userName) {
        Users user = userEntryService.getUserByUserName(userName);
        user.getJournalEntry().removeIf(i -> user.getId().equals(journalId));
        userEntryService.saveUser(user);
        journalEntryRepo.deleteById(journalId);
    }

    public void updateEntry(JournalEntry entry) {
        return;
    }

    @Transactional
    public boolean deleteByJournalId(ObjectId journalId,String userName) {
        boolean result = false;
        try {
            Users user = userEntryService.getUserByUserName(userName);
            result = user.getJournalEntry().removeIf(i -> i.getId().equals(journalId));
            if (result) {
                userEntryService.saveUser(user);
                journalEntryRepo.deleteById(journalId);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
}
