export default class ForgotPasswordController {
  async create(request, response) {
    const {
      email,
      firstName,
      lastName,
      credentials
    } = request.body;

    const sendForgotPasswordEmail = container.resolve(
      SendForgotPasswordEmailService,
    );

    await sendForgotPasswordEmail.execute({ email });

    return response.status(204).json();
  }
}