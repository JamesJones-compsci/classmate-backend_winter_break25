// ===============================
// TASK SERVICE COLLECTION
// ===============================
db = db.getSiblingDB("taskdb");
db.tasks.insertMany([
    { title: "Finish Assignment", description: "Complete Java assignment", status: "pending" },
    { title: "Read Docs", description: "Read Docker docs", status: "done" }
]);

// ===============================
// REMINDER SERVICE COLLECTION
// ===============================
db = db.getSiblingDB("reminderdb");
db.reminders.insertMany([
    { message: "Meeting at 3PM", user: "James", date: "2025-12-24" },
    { message: "Submit Report", user: "James", date: "2025-12-25" }
]);
