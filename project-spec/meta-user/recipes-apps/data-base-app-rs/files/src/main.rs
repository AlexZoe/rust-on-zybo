use table_database_rs;

fn main() {
    let ctx = unsafe { table_database_rs::open_database() };
    println!("Hello, world!");
}
