export class Employee {
    employeeId: number;
    employeeFirstName: string | undefined;
    employeeLastName: string | undefined;
    employeeJobTitle: string | undefined;
    employeeSalary: string | undefined;
    employeeHomeAddress: string | undefined;
    employeeSSN: string | undefined;

    constructor (employeeId: number) {
        this.employeeId = employeeId;
    }
}
