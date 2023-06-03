/*
 * This class file would contain every methods 
 * for doing CRUD (CREATE , READ, UPDATE, DELETE) 
 * company and other relevant informations 
 * to a database. 
 * 
 * Server needs to established before it can receive or send request 
 * from the backend system. The backend operation itself would be in 
 * these files.
 * 
 * For example, in Golang, this is a snippet of code 
 * for getting clients data from PostgreSQL database
 * 
 * func GetAllClients(db *sql.DB) (err error, results []structs.Client) {
	sql := `SELECT *FROM client`

	rows, err := db.Query(sql)
	CheckErr(err)
	defer rows.Close()

	for rows.Next() {
		var b = structs.Client{}

		err = rows.Scan(&b.ID, &b.Name, &b.Description, &b.CreateDate, &b.UpdateDate, &b.City, &b.Province, &b.AddressID)
		CheckErr(err)
		results = append(results, b)

	}
	return

}
 */


 /*
  * 






  1aeraer
  2
  3
  4
  5
  */

