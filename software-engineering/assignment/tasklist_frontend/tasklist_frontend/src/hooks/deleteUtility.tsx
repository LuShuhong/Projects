
export const deleteFuntion = async(url:string, id:string) =>{
    try{
      const response = await fetch(`${url}/${id}`, {
        method: 'DELETE',
      });
      if(!response.ok) {
        throw new Error(`Error: ${response.status}`)
      }
    } catch(error) {
      console.error("Failed to delete")
    }

  }