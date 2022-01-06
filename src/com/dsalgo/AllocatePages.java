package com.dsalgo;

//https://www.interviewbit.com/problems/allocate-books/
/*Given an array of integers A of size N and an integer B.

        College library has N bags,the ith book has A[i] number of pages.

        You have to allocate books to B number of students so that maximum number of pages alloted
        to a student is minimum.

        A book will be allocated to exactly one student.
        Each student has to be allocated at least one book.
        Allotment should be in contiguous order, for example: A student cannot be allocated book 1
        and book 3, skipping book 2.
        Calculate and return that minimum possible number.

        NOTE: Return -1 if a valid assignment is not possible.*/
//tc-logN*n
public class AllocatePages {

    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;

        int pages = allocateBooksToStudents(books, students);
        System.out.println("Min number of pages:" + pages);
    }

    private static int allocateBooksToStudents(int[] books, int students) {

        if (books.length == 0 || (books.length == 1 && students > 1)) {
            return -1;
        }
        int low = books[0];
        int high = 0;
        for (int i = 0; i < books.length; i++) {
            high = high + books[i];
            low = Math.min(low, books[i]);
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (allocationPossible(mid, books, students)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean allocationPossible(int barrier, int[] books, int students) {
        int allocateStudents = 0, pages = 0;

        for (int i = 0; i < books.length; i++) {

            if (books[i] + pages > barrier) {
                allocateStudents++;
                pages = books[i];
                if (pages > barrier) {
                    return false;
                }
            } else {
                pages += books[i];
            }
        }
        if (allocateStudents < students) {
            return true;
        }
        return false;
    }
}
