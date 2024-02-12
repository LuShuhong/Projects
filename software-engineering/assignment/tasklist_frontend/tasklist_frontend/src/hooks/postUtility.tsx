export interface PostData {
    // created_at: string;
    // from:string;
    // behaviour_score:string;
    // message_for_santa:string;
    // item_names:string
}



export const postFunction = async (url: string, postData: PostData) => {
  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(postData),
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    return response.json();
  } catch (error) {
    console.error(error);
  }
};
