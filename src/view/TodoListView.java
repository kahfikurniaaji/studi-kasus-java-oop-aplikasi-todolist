package view;

import service.TodoListService;
import service.TodoListServiceImpl;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Todo (x Jika Batal)");

        // cek apakah todo sama dengan "x"?
        if (todo.equals("x")) {
            // Batal
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Nomor yang Dihapus (x Jika Batal)");

        // cek apakah number sama dengan "x"?
        if (number.equals("x")) {
            // Batal
        } else {
            try {
                todoListService.removeTodoList(Integer.valueOf(number));
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }
    }
}
