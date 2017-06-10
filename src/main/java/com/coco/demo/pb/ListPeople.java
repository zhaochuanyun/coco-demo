package com.coco.demo.pb;

import java.io.FileInputStream;

import com.coco.demo.pb.AddressBookProtos.AddressBook;
import com.coco.demo.pb.AddressBookProtos.Person;

/**
 * protocol buffer基础
 * @see http://blog.csdn.net/zhaozheng7758/article/details/6749028
 * @author zhaochuanyun379
 *
 */
class ListPeople {

    // Iterates though all people in the AddressBook and prints info about them.
    static void Print(AddressBook addressBook) {
        for (Person person : addressBook.getPersonList()) {
            System.out.println("Person ID: " + person.getId());
            System.out.println("  Name: " + person.getName());
            if (person.hasEmail()) {
                System.out.println("  E-mail address: " + person.getEmail());
            }

            for (Person.PhoneNumber phoneNumber : person.getPhoneList()) {
                switch (phoneNumber.getType()) {
                    case MOBILE:
                        System.out.print("  Mobile phone #: ");
                        break;
                    case HOME:
                        System.out.print("  Home phone #: ");
                        break;
                    case WORK:
                        System.out.print("  Work phone #: ");
                        break;
                }
                System.out.println(phoneNumber.getNumber());
            }
        }
    }

    // Main function: Reads the entire address book from a file and prints all
    // the information inside.
    public static void main(String[] args) throws Exception {
        String[] path = { "D:/protoc-2.6.1-win32/data/proto_data" };

        if (path.length != 1) {
            System.err.println("Usage:  ListPeople ADDRESS_BOOK_FILE");
            System.exit(-1);
        }

        // Read the existing address book.
        AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(path[0]));

        Print(addressBook);
    }

}
